public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    int tc = scan.nextInt(), l, n;
    for(int i = 0; i < tc; i++) {
        l = scan.nextInt();
        n = scan.nextInt();

        int min = 0;
        int max = 0;
        for (int j = 0; j < n; j++) {
            int ant = scan.nextInt();
            int temp = Math.min(ant, l-ant);
            min = Math.max(min, temp);
            max = Math.max(ant,max);
            max = Math.max(l-ant,max);
        }
        System.out.println(min +" "+ max);
    }
}
