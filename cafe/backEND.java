package cafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static GUI.Admin.peakTimeAnalysisPage.peakTime;

public class backEND {

//4th rating system
public static  double CalculateAverageRating() {
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
    //6th average student number
    //public static String busyTime(){
     //   peakTime = identifyPeakTime(backEND.getTimestampData());
  //  return peakTime;
   // }
    public static String  FavoriteFood() {
        int[] totalCounts = new int[]{10, 34, 25};
        String[] foodChoice = new String[]{"firfir", "dabo", "colo"};
        int max = totalCounts[0];
        String food = null;
        for (int i = 1; i < totalCounts.length; i++) {
            if (totalCounts[i] > max) {
                max = totalCounts[i];
                food = foodChoice[i];
            }

        }

        return food;
    }
    public static List<String > getTimestampData(){
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
        return timestampData;
    }

    public static String identifyPeakTime(List<String> timestampData) {

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





