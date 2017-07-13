import java.util.*;
import java.util.Arrays;

public class CoveringSegments {

    private static List<Integer> optimalPoints(Segment[] segments) {
        Arrays.sort(segments);

        List<Integer> points = new ArrayList<Integer>();
        Segment commonSegment = new Segment(-1, -1);
        for (int i = 0; i < segments.length; i++) {
            // Check if common segment is covered
            if (segments[i].start > commonSegment.end) {
                if(commonSegment.end > -1) {
                    points.add(commonSegment.end);
                }
                commonSegment.start = segments[i].start;
                commonSegment.end = segments[i].end;
            } else {
                if(segments[i].start > commonSegment.start) {
                    commonSegment.start = segments[i].start;
                }
                if(segments[i].end < commonSegment.end) {
                    commonSegment.end = segments[i].end;
                }
            }
        }
        if (commonSegment.end != -1) {
            points.add(commonSegment.end);
        }
        return points;
    }

    private static class Segment implements Comparable<Segment> {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Segment segment) {
            if (this.start == segment.start && this.end == segment.end) {
                return 0;
            }
            if (this.start == segment.start) {
                return Integer.compare(this.end, segment.end);
            }
            return Integer.compare(this.start, segment.start);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
