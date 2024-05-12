public class PerlinNoiseGenerator {
    private static final int P = 256;
    private static final int[] permutation = new int[P];
    private static final double[] gradients = new double[P];

    static {
        for (int i = 0; i < P; i++) {
            permutation[i] = i;
        }
        for (int i = 0; i < P; i++) {
            int j = (int) (Math.random() * P);
            int k = permutation[i];
            permutation[i] = permutation[j];
            permutation[j] = k;
        }
        for (int i = 0; i < P; i++) {
            gradients[i] = Math.random() * 2 - 1;
        }
    }

    public static double noise(double x, double y) {
        int xi = (int) Math.floor(x) & (P - 1);
        int yi = (int) Math.floor(y) & (P - 1);
        double xf = x - Math.floor(x);
        double yf = y - Math.floor(y);
        double u = fade(xf);
        double v = fade(yf);
        int a = permutation[xi] + yi;
        int b = permutation[xi + 1] + yi;
        int c = permutation[xi] + yi + 1;
        int d = permutation[xi + 1] + yi + 1;
        double x1 = gradients[a & (P - 1)];
        double x2 = gradients[b & (P - 1)];
        double x3 = gradients[c & (P - 1)];
        double x4 = gradients[d & (P - 1)];
        double y1 = gradients[(a + 1) & (P - 1)];
        double y2 = gradients[(b + 1) & (P - 1)];
        double y3 = gradients[(c + 1) & (P - 1)];
        double y4 = gradients[(d + 1) & (P - 1)];
        return lerp(v, lerp(u, lerp(x1, x2, xf), lerp(x3, x4, xf), yf),
                lerp(u, lerp(y1, y2, xf), lerp(y3, y4, xf), yf));
    }

    private static double fade(double t) {
        return t * t * t * (t * (t * 6 - 15) + 10);
    }

    private static double lerp(double t, double a, double b) {
        return a + t * (b - a);
    }
}
