package com.example.lab8nk;

public class Restaurant {
    private String selectedRestaurant;
    private String restaurantURL;
    private String address;


    public void setInfo(Integer type){
        switch (type){
            case 0:
                selectedRestaurant = "Bento-ria";
                restaurantURL="http://places.singleplatform.com/bento-ria-sushi/menu";
                address = "1325 Broadway, Boulder, CO 80302";
                break;
            case 1:
                selectedRestaurant = "Pizzeria Locale";
                restaurantURL="https://www.localeboulder.com/menus/";
                address = "1730 Pearl St, Boulder, CO 80302";
                break;
            case 2:
                selectedRestaurant = "Cilantro";
                restaurantURL="https://cilantro-mexican-restaurant.business.site/";
                address = "3980 Broadway Suit 104, Boulder, CO 80304";
                break;
            case 3:
                selectedRestaurant = "Flower Pepper";
                restaurantURL="http://flowerpeppereats.com/";
                address = "2655 Broadway, Boulder, CO 80304";
                break;
            case 4:
                selectedRestaurant = "Khow Thai Cafe";
                restaurantURL="https://khow-thai.com/";
                address = "1600 Broadway, Boulder, CO 80302";
                break;
            case 5:
                selectedRestaurant = "Carelli's Of Boulder";
                restaurantURL="https://carellis.com/";
                address = "645 30th St, Boulder, CO 80303";
                break;
            default:
                selectedRestaurant= "How did you get this";
                restaurantURL = "";
                address= "mystery go wherever your heart wants";
                break;


        }
    }

    String getSelectedRestaurant(){
        return selectedRestaurant;
    }

    String getRestaurantURL(){
        return restaurantURL;
    }

    String getAddress(){
        return address;
    }


}

