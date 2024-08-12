class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = 0;
            char c = s.charAt(i);

            if (c == 'I') currentValue = 1;
            else if (c == 'V') currentValue = 5;
            else if (c == 'X') currentValue = 10;
            else if (c == 'L') currentValue = 50;
            else if (c == 'C') currentValue = 100;
            else if (c == 'D') currentValue = 500;
            else if (c == 'M') currentValue = 1000;

            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }

            prevValue = currentValue;
        }

        return total;
    }
}
