public class Main {
    public static void main(String[] args) {
        APIBored apiBored = new APIBored();
        System.out.println(apiBored.getContentResponse());
        apiBored.SaveFile();
        
    }
}
