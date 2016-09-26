package be.pxl.ioc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MoonDollahsCoffeeShop {

    private List<Barista> baristas = new ArrayList<>();

    MoonDollahsCoffeeShop() {
        Barista vicky = new Barista("vicky",new CustomerFriendlyWorkEthic());
        Barista emma = new Barista("gemma",new LazyWorkEthic());
        Barista gianluca = new Barista("gianluca",new BadHearingWorkEthic());

        baristas = Arrays.asList(vicky, emma, gianluca);
    }

    private void serve(List<String> customers) {
        customers.stream().map(this::serve).forEach(System.out::println);
    }

    private CustomerExperience serve(String customer) {
        int random = ThreadLocalRandom.current().nextInt(0, baristas.size());
        return baristas.get(random).serve(customer);
    }

    List<Barista> getBaristas() {
        return baristas;
    }

    public static void main(String[] args) {
        MoonDollahsCoffeeShop shop = new MoonDollahsCoffeeShop();


        List<String> customers = Arrays.asList("meliodas", "ban", "elizabeth", "king", "merlin", "howther", "diane", "escanor");
        shop.serve(customers);
    }

}
