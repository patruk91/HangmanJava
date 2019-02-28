public class Hangman {
    public static void main(String[] args) {

//        DataManager dataManager = new DataManager();
//        ArrayList<Country> data = dataManager.getCountriesAndCapitals();
//        for (Country item : data) {
//            System.out.print(item.toString());
//
//        }


        Word word = new Word();
        System.out.println(word.toString());

        System.out.println(word.getRandomCountry());
        System.out.println(word.getRandomCapital());




    }
}
