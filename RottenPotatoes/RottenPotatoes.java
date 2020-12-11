public class RottenPotatoes {

    public static void main(String[] args) {

        int[][] ratings = { {4,6,2,5},
                            {7,9,4,8},
                            {6,9,3,7} };

        System.out.println("Movie zero's average rating: " + movieAvgRating(ratings, 0));                    
        System.out.println("Movie one's average rating: " + movieAvgRating(ratings, 1));    
        System.out.println("Reviewer zero's average rating: " + reviewerAvgRating(ratings, 0));    
        System.out.println("Reviewer one's average rating: " + reviewerAvgRating(ratings, 1));
        System.out.println("Average rating for all movies in 2018: " + avgRating2018(ratings));    
        System.out.println("Hardest reviewer is #" + hardestReviewer2018(ratings));
        System.out.println("Worst movie is #" + worstMovie2018(ratings));
    }

    //Question 1
    public static int movieAvgRating(int[][] ratings, int movie) {
        int avgRating = 0;
        for (int r = 0; r < ratings.length; r++) {
         avgRating += ratings[r][movie];    
        }
        avgRating = avgRating/3;
        return avgRating;
    }

    //Question 2
    public static int reviewerAvgRating(int[][] ratings,int reviewer) {
        int avgRating = 0;
        for (int c = 0; c < ratings[reviewer].length; c++){
         avgRating += ratings[reviewer][c];   
        }
        avgRating /= 4;
        return avgRating;        
    }

    //Question 3
    public static int avgRating2018(int[][] ratings) {
        int avgAll = 0;
        for (int r = 0; r < ratings.length; r++){
         for (int c = 0; c < ratings[0].length; c++){
             avgAll += ratings[r][c];
            }
        }
        avgAll /= 12;
        return avgAll;
    }

    //Question 4
    public static int hardestReviewer2018(int[][] ratings) {
        int avg0 = 0;
        int avg1 = 0;
        int avg2 = 0;
        for (int r = 0; r < ratings.length; r++) {
         for (int c = 0; c < ratings[0].length; c++) {
             if (r == 0) avg0 += ratings[0][c];
             if (r == 1) avg1 += ratings[1][c];
             if (r == 2) avg2 += ratings[2][c];
            }
        }
        avg0 /= 4;
        avg1 /= 4;
        avg2 /= 4;
        int hardest = Math.min(Math.min(avg0,avg1),Math.min(avg1,avg2));
        if (hardest == avg0) return 0;
        if (hardest == avg1) return 1;
        if (hardest == avg2) return 2;
        return -1;
    }

    //question 5
    public static int worstMovie2018(int[][] ratings) {
        int avg0 = 0;
        int avg1 = 0;
        int avg2 = 0;
        int avg3 = 0;
        for (int c = 0; c < ratings[0].length; c++) {
         for (int r = 0; r < ratings.length; r++) {
             if (c == 0) avg0 += ratings[r][0];
             if (c == 1) avg1 += ratings[r][1];
             if (c == 2) avg2 += ratings[r][2];
             if (c == 3) avg3 += ratings[r][3];
            }
        }
        int worst = Math.min(Math.min(avg0,avg1),Math.min(avg1,avg2));
        if (worst == avg0) return 0;
        if (worst == avg1) return 1;
        if (worst == avg2) return 2;
        if (worst == avg3) return 3;
        return -1;
    }   
}