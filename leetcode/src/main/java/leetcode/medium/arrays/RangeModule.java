package leetcode.medium.arrays;

import java.util.*;

class RangeModule {


    TreeSet<Interval> set;

    public RangeModule() {

        set = new TreeSet<>();
    }

    public void addRange(int left, int right) {


        Iterator<Interval> itr = set.tailSet(new Interval(0, left - 1)).iterator();

        while (itr.hasNext()) {
            Interval interval = itr.next();
            if (right < interval.left) break;
            left = Math.min(interval.left, left);
            right = Math.max(interval.right, right);
            itr.remove();
        }

        set.add(new Interval(left, right));
    }

    public boolean queryRange(int left, int right) {
        Interval interval = set.higher(new Interval(0, left));
        return (interval != null) && interval.left <= left && right <= interval.right;
    }

    public void removeRange(int left, int right) {
        Iterator<Interval> itr = set.tailSet(new Interval(0, left)).iterator();
        List<Interval> temp = new ArrayList<>();
        while (itr.hasNext()) {
            Interval interval = itr.next();

            if (right < interval.left) break;
            if (interval.left < left) {
                temp.add(new Interval(interval.left, left));

            }

            if (right < interval.right) {
                temp.add(new Interval(right, interval.right));
            }
            itr.remove();
        }

        for (Interval i : temp) {
            set.add(i);
        }

    }

    class Interval implements Comparable<Interval> {
        int left;
        int right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int compareTo(Interval interval) {
            if (this.right != interval.right) {
                return this.right - interval.right;
            }
            return this.left - interval.left;

        }
    }

}

