package cafe;    //daily comparative graph : breakfast, lunch , dinner

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
    import java.awt.*;
    import java.awt.geom.Ellipse2D;
    import java.awt.geom.RoundRectangle2D;
    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.List;
    import java.util.*;

    public class attendance {
        public static void main(String[] args) {
            //int[] totalCounts ={10,23,56};
                    // retrieveTotalCountsFromDatabase();  Retrieve total counts from the database

            createBarGraph();
            plotAttendanceGraph();
            pie();
            double averageRating = calculateAverageRating();
            System.out.println("Average Rating: " + averageRating);
            // Identify the peak attendance time

        }
        //daily comparative graph : breakfast, lunch , dinner
        public static void createBarGraph() {
           int[] totalCounts= new int[]{10, 23,34};
                    //retrieveTotalCountsFromDatabase();
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
            renderer.setDefaultPositiveItemLabelPosition(
                    new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));




            renderer.setSeriesPaint(0, Color.YELLOW); // Customize bar color for Breakfast
            renderer.setSeriesPaint(1, Color.GREEN); // Customize bar color for Dinner
            renderer.setSeriesPaint(2, Color.RED); // Customize bar color for Lunch

            renderer.setShadowVisible(false);
            renderer.setBarPainter(new StandardBarPainter());

            renderer.setDefaultOutlineStroke(new BasicStroke(1.5f)); // Set item label outline stroke




            ChartFrame frame = new ChartFrame("Bar Graph", chart);
            frame.pack();
            frame.setVisible(true);
        }
      //2nd part
      //peak time analysis

      public static void plotAttendanceGraph() {
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
          SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm");

          for (String timestamp : timestampData) {
              try {
                  Date date = inputFormat.parse(timestamp);
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
                  dataset
          );
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

          // Display the chart in a frame
          ChartFrame frame = new ChartFrame("Student Attendance Graph", chart);
          frame.pack();
          frame.setVisible(true);
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
//3 pie chart for number of students in each department analysis
public static void pie() {
    DefaultPieDataset dataset = new DefaultPieDataset();
    String[] departments = {"Department A", "Department B", "Department C"};//amir give me the array of department
    int[] studentCounts = {50, 75, 30};//ammmir give me te array of student count oy;

    for (int i = 0; i < departments.length; i++) {
        dataset.setValue(departments[i], studentCounts[i]);
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

    plot.setSectionPaint(departments[0], new Color(0, 123, 255)); // Set color for Department A
    plot.setSectionPaint(departments[1], new Color(220, 53, 69)); // Set color for Department B
    plot.setSectionPaint(departments[2], new Color(40, 167, 69)); // Set color for Department C
    plot.setExplodePercent(departments[1], 0.1); // Explode Department B slice by 10%

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

    // Display the chart panel
    JFrame frame = new JFrame("Student Distribution Pie Chart");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.WHITE);
    frame.getContentPane().add(chartPanel);
    frame.pack();
    frame.setVisible(true);

}
//4th rating system
public static double calculateAverageRating() {
    int[] ratings = { 4, 5, 3, 2, 4, 5 };//amir
    int sum = 0;

    for (int rating : ratings) {
        sum += rating;
    }

    return (double) sum / ratings.length;
}
//5th average student number
public static int averageStudentPresented(){
        int [] ASP={10, 30,40};
        int sum=0;
        for(int i=0; i< ASP.length;i++){
            sum+=ASP[i];
        }
        //System.out.println(sum);
        int average=sum/ASP.length;
        return average;
    }
}





