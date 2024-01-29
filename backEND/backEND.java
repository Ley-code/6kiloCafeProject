package backEND;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Database.ConnectionWithDatabase.numOfStudent;
import static Database.ConnectionWithDatabase.timeForPeakAnalysis;

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
        ArrayList<Integer> ASP= numOfStudent();
        int sum=0;
        for(int i=0; i< 3;i++){
            sum+= ASP.get(i);
        }
        //System.out.println(sum);
        int average=sum/3;
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
            if (totalCounts[i] >= max) {
                max = totalCounts[i];
                food = foodChoice[i];
            }
                        }


        return food;
    }
    public static String LeastFavorite(){
        int[] totalCounts = new int[]{10, 34, 45};
        String[] foodChoice = new String[]{"firfir", "dabo", "colo"};
        int min = totalCounts[0];
        String food = null;
        for(int i=0; i<totalCounts.length; i++){
            if(totalCounts[i]<=min){
                min=totalCounts[i];
                food=foodChoice[i];
            }
        }
    return food;
    }

    public static List<String> getTimestampData(){
        ArrayList<LocalTime> timestampData = timeForPeakAnalysis();

        // Generate sample timestamp data
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





