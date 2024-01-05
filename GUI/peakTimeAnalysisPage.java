package GUI;
//daily comparative graph : breakfast, lunch , dinner

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import java.util.*;

public class peakTimeAnalysisPage extends WelcomePage {

    public peakTimeAnalysisPage(){
        JPanel mypanel = new JPanel();
        mypanel.setLayout(new GridLayout(2,1));
        mypanel.setBorder(new EmptyBorder(30,30,30,30));
        mypanel.add(peakTimeAnalysisPage.createBarGraph());
        mypanel.add(peakTimeAnalysisPage.plotAttendanceGraph());
        JScrollPane scrollpane = new JScrollPane(mypanel);
        centerPanel.setLayout(new GridLayout(1,1));
        centerPanel.add(scrollpane);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new peakTimeAnalysisPage();
    }
    public static ChartPanel createBarGraph() {
        int[] totalCounts = new int[] { 10, 34, 25 };
        // retrieveTotalCountsFromDatabase();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(totalCounts[0], "Breakfast", "Breakfast");
        dataset.addValue(totalCounts[1], "Lunch", "Lunch");
        dataset.addValue(totalCounts[2], "Dinner", "Dinner");

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
        return myChartPanel;
    }

    // 2nd part
    // peak time analysis

    public static ChartPanel plotAttendanceGraph() {
        // List<String> timestampData = retrieveTimestampData();
        List<String> timestampData = new ArrayList<>();

        // Generate sample timestamp data
        timestampData.add("2022-01-01 09:02:00");
        timestampData.add("2022-01-01 09:15:00");
        timestampData.add("2022-01-01 09:30:00");
        timestampData.add("2022-01-01 09:30:00");
        timestampData.add("2022-01-01 09:45:30");
        timestampData.add("2022-01-01 09:45:00");
        timestampData.add("2022-01-01 09:45:00");
        timestampData.add("2022-01-01 10:00:00");
        timestampData.add("2022-01-01 10:15:00");
        timestampData.add("2022-01-01 10:15:00");
        timestampData.add("2022-01-01 10:30:00");
        timestampData.add("2022-01-01 10:30:00");
        String peakTime = identifyPeakTime(timestampData);
        System.out.println("Peak Attendance Time: " + peakTime);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Map<String, Integer> intervalCountMap = new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (String timestamp : timestampData) {
            try {
                Date date = dateFormat.parse(timestamp);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.set(Calendar.SECOND, 0); // Reset seconds to zero
                String intervalStart = dateFormat.format(calendar.getTime());

                calendar.add(Calendar.MINUTE, 1); // Add one minute
                String intervalEnd = dateFormat.format(calendar.getTime());

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

        /*
         * // Count the number of students for each timestamp
         * Map<String, Integer> timestampCountMap = new HashMap<>();
         * for (String timestamp : timestampData) {
         * timestampCountMap.put(timestamp, timestampCountMap.getOrDefault(timestamp, 0)
         * + 1);
         * }
         * 
         * // Add data points to the dataset
         * for (Map.Entry<String, Integer> entry : timestampCountMap.entrySet()) {
         * String timestamp = entry.getKey();
         * Integer count = entry.getValue();
         * dataset.addValue(count, "Attendance", timestamp);
         * }
         */
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
        ChartPanel peakPanel = chartFrame.getChartPanel();
        return peakPanel;

    }

    private static String identifyPeakTime(List<String> timestampData) {

        Map<String, Integer> timestampCountMap = new HashMap<>();

        // Count the number of students for each timestamp
        for (String timestamp : timestampData) {
            timestampCountMap.put(timestamp, timestampCountMap.getOrDefault(timestamp, 0) + 1);
        }

        // Find the timestamp with the maximum student count
        String peakTime = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : timestampCountMap.entrySet()) {
            String timestamp = entry.getKey();
            Integer count = entry.getValue();
            if (count > maxCount) {
                maxCount = count;
                peakTime = timestamp;
            }
        }
        return peakTime;
    }

}
