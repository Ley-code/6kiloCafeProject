package GUI.Admin;
//daily comparative graph : breakfast, lunch , dinner
import backEND.backEND;



import Database.ConnectionWithDatabase;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import java.util.*;

import static Database.ConnectionWithDatabase.numofStudentInDepartment;
import static backEND.backEND.getKeysFromHashMap;
import static backEND.backEND.getValuesFromHashMap;

public class graphAndChartPage extends WelcomePage {
    private JButton breakFastButton;
    private JButton lunchButton;
    private JButton dinnerButton;
    private JPanel mypanel;
    private JPanel centerlayout;
    private JPanel buttonlayout;
    private static int flag = 0;
    public static int getFlag(){
        return flag;
    }
    public static String peakTime;
    public graphAndChartPage(){
        breakFastButton = new JButton("break fast");
        breakFastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 0;
            }
        });
        lunchButton = new JButton("Lunch");
        lunchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 1;
            }
        });
        dinnerButton = new JButton("Dinner");
        dinnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 2;
            }
        });
        buttonlayout = new JPanel();
        buttonlayout.setLayout(new FlowLayout(FlowLayout.CENTER,40,10));
        buttonlayout.add(breakFastButton);
        buttonlayout.add(lunchButton);
        buttonlayout.add(dinnerButton);

        centerlayout = new JPanel();
        centerlayout.setLayout(new BorderLayout());
        centerlayout.add(buttonlayout,BorderLayout.NORTH);
        centerlayout.add(graphAndChartPage.plotAttendanceGraph(),BorderLayout.CENTER);

        mypanel = new JPanel();
        mypanel.setLayout(new GridLayout(3,1,30,30));
        mypanel.setBorder(new EmptyBorder(30,30,30,30));
        mypanel.add(graphAndChartPage.createBarGraph());
        mypanel.add(centerlayout);
        mypanel.add(graphAndChartPage.pie());

        JScrollPane scrollpane = new JScrollPane(mypanel);
        centerPanel.setLayout(new GridLayout(1,1));
        centerPanel.add(scrollpane);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
    public static ChartPanel createBarGraph() {
        ArrayList<Integer> totalCounts =ConnectionWithDatabase.numOfStudent();
                //new int[] { 10, 34, 25 };
        // retrieveTotalCountsFromDatabase();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(totalCounts.get(0), "Breakfast", "Breakfast");
        dataset.addValue(totalCounts.get(1), "Lunch", "Lunch");
        dataset.addValue(totalCounts.get(2), "Dinner", "Dinner");

        JFreeChart chart = ChartFactory.createBarChart(
                "Daily comparative graph : breakfast, lunch , dinner", // Chart title
                "Meal", // X-axis label
                "Number of students", // Y-axis label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot orientation
                true, // Show legend
                true, // Use tooltips
                false // Generate URLs
        );
// Customize plot area
        CategoryPlot plot = chart.getCategoryPlot();

        plot.setBackgroundPaint(Color.lightGray); // Set plot background color
        plot.setOutlinePaint(null); // Hide the plot outline
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(new Color(0, 0, 0)); // Set color of range gridlines
// Customize X-axis
// Customize Y-axis
        NumberAxis valueAxis = (NumberAxis) plot.getRangeAxis();
        valueAxis.setTickLabelFont(new Font("Arial", Font.PLAIN, 16));
        valueAxis.setTickLabelsVisible(true);
        valueAxis.setTickLabelPaint(new Color(59, 89, 152)); // Set tick label color

// Customize renderer
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardBarPainter());
        renderer.setDrawBarOutline(true); // Hide bar outlines
        renderer.setShadowVisible(true); // Hide shadows
        renderer.setSeriesPaint(0, new Color(59, 89, 152)); // Set custom bar color

// Display label for each bar
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));

        renderer.setSeriesPaint(0, Color.YELLOW); // Customize bar color for Breakfast
        renderer.setSeriesPaint(1, Color.GREEN); // Customize bar color for Dinner
        renderer.setSeriesPaint(2, Color.RED); // Customize bar color for Lunch

        renderer.setShadowVisible(false);
        renderer.setBarPainter(new StandardBarPainter());

        renderer.setDefaultOutlineStroke(new BasicStroke(1.5f)); // Set item label outline stroke

        ChartFrame chartFrame = new ChartFrame("Bar Graph", chart);
        chartFrame.pack();
        ChartPanel myChartPanel = chartFrame.getChartPanel();
        myChartPanel.setBorder(new LineBorder(Color.BLACK,5,true));
        return myChartPanel;
    }

// 2nd part
// peak time analysis

    public static ChartPanel plotAttendanceGraph() {
        // List<String> timestampData = retrieveTimestampData();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String, Integer> intervalCountMap = new HashMap<>();
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm");

        for (LocalTime timestamp : backEND.getTimestampData()) {
            try {
                Date date = inputFormat.parse(String.valueOf(timestamp));
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.set(Calendar.SECOND, 0); // Reset seconds to zero
                calendar.set(Calendar.MILLISECOND, 0); // Reset milliseconds to zero

// Round minutes to the nearest multiple of 5
                int minute = calendar.get(Calendar.MINUTE);
                int roundedMinute = (minute / 5) * 5;
                calendar.set(Calendar.MINUTE, roundedMinute);

                String intervalStart = outputFormat.format(calendar.getTime());

                calendar.add(Calendar.MINUTE, 15); // Add five minutes
                String intervalEnd = outputFormat.format(calendar.getTime());

                String interval = intervalStart + " - " + intervalEnd;

                intervalCountMap.put(interval, intervalCountMap.getOrDefault(interval, 0) + 1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

// Add data points to the dataset
        for (Map.Entry<String, Integer> entry : intervalCountMap.entrySet()) {
            String interval = entry.getKey();
            Integer count = entry.getValue();
            dataset.addValue(count, "Attendance", interval);
        }
// Create the chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Student Attendance",
                "Timestamp",
                "Number of Students",
                dataset);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();

// Make the line bold
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

// Customize other aspects of the plot, such as colors and shapes
        renderer.setSeriesPaint(0, Color.BLUE); // Customize line color
        renderer.setSeriesShapesVisible(0, true); // Show data points as shapes
        renderer.setSeriesShape(0, new Ellipse2D.Double(-3, -3, 6, 6)); // Customize shape of data points

// Customize the axis labels
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setLabelFont(new Font("Arial", Font.BOLD, 14));
        domainAxis.setTickLabelFont(new Font("Arial", Font.PLAIN, 12));

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("Arial", Font.BOLD, 14));
        rangeAxis.setTickLabelFont(new Font("Arial", Font.PLAIN, 12));

// Display the chart in a chartFrame
        ChartFrame chartFrame = new ChartFrame("Student Attendance Graph", chart);
        chartFrame.pack();
        ChartPanel myChartPanel = chartFrame.getChartPanel();
        myChartPanel.setBorder(new LineBorder(Color.BLACK,5,true));
        return myChartPanel;

    }
//3 pie chart for number of students in each department analysis
    public static ChartPanel pie() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        ConnectionWithDatabase.numofStudentInDepartment();
        HashMap<String, Integer> studentInDepartment = numofStudentInDepartment();
        ArrayList<String> departments = getKeysFromHashMap(studentInDepartment);
        ArrayList<Integer> counts = getValuesFromHashMap(studentInDepartment);
        for (int i = 0; i < departments.size(); i++) {
            dataset.setValue(departments.get(i), counts.get(i));

        }

// Create the pie chart
        JFreeChart chart = ChartFactory.createPieChart(null, dataset, false, false, false);

// Customize the appearance of the chart
        chart.setBackgroundPaint(Color.WHITE);
        chart.setBorderVisible(false);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSimpleLabels(true); // Use simple labels instead of percentages
        plot.setLabelGap(0.02);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1} ({2})"));

        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setShadowPaint(null);

        plot.setSectionPaint(departments.get(0), new Color(0, 123, 255)); // Set color for Department A
        plot.setSectionPaint(departments.get(1), new Color(220, 53, 69)); // Set color for Department B
        plot.setSectionPaint(departments.get(2), new Color(40, 167, 69)); // Set color for Department C
        plot.setExplodePercent(departments.get(1), 0.1); // Explode Department B slice by 10%

        plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({1})")); // Show department name and count in the legend
        plot.setLegendLabelToolTipGenerator(new StandardPieSectionLabelGenerator("{0} : {1}"));

// Add a title to the chart
        TextTitle title = new TextTitle("Student Distribution Pie Chart");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setPaint(new Color(33, 37, 41));
        chart.setTitle(title);
        // Create a chart panel with custom rounded edges
        ChartPanel chartPanel = new ChartPanel(chart) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
                g2.setStroke(new BasicStroke(2));
                g2.setColor(new Color(220, 220, 220));
                g2.draw(roundedRectangle);
            }
        };
        chartPanel.setBorder(new LineBorder(Color.BLACK,5,true));
// Display the chart panel
        return chartPanel;
    }
}

