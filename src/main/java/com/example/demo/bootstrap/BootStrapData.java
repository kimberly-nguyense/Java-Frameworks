package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private List<Product> productList;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (outsourcedPartRepository.count()!=0 || productRepository.count()!=0){
            return;
        }

        OutsourcedPart outsourcedPart= new OutsourcedPart();
        outsourcedPart.setCompanyName("Vending Machine");
        outsourcedPart.setName("Espresso");
        outsourcedPart.setInv(5);
        outsourcedPart.setPrice(3.00);
        outsourcedPart.setId(100);
        outsourcedPartRepository.save(outsourcedPart);
        outsourcedPart.setCompanyName("Vending Machine");
        outsourcedPart.setName("Latte");
        outsourcedPart.setInv(5);
        outsourcedPart.setPrice(5.00);
        outsourcedPart.setId(101);
        outsourcedPartRepository.save(outsourcedPart);
        outsourcedPart.setCompanyName("Supermarket Bakery");
        outsourcedPart.setName("Croissaint");
        outsourcedPart.setInv(5);
        outsourcedPart.setPrice(3.50);
        outsourcedPart.setId(102);
        outsourcedPartRepository.save(outsourcedPart);
        outsourcedPart.setCompanyName("Supermarket Bakery");
        outsourcedPart.setName("Muffin");
        outsourcedPart.setInv(5);
        outsourcedPart.setPrice(4.00);
        outsourcedPart.setId(103);
        outsourcedPartRepository.save(outsourcedPart);
        outsourcedPart.setCompanyName("Supermarket");
        outsourcedPart.setName("Whipped Cream");
        outsourcedPart.setInv(20);
        outsourcedPart.setPrice(1.00);
        outsourcedPart.setId(104);
        outsourcedPartRepository.save(outsourcedPart);

//        OutsourcedPart thePart=null;
//        List<OutsourcedPart> outsourcedPartList=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
//        for(OutsourcedPart part:outsourcedPartList){
//            if(part.getName().equals("Coffee"))thePart=part;
//        }
//        System.out.println(thePart.getCompanyName());
//
//
//        for(OutsourcedPart part:outsourcedPartList){
//            System.out.println(part.getName()+" "+part.getCompanyName());
//        }

        Product setA= new Product("A. Espresso with Croissant",5.50,3);
        Product setB= new Product("B. Espresso with Muffin",6.00,3);
        Product setC= new Product("C. Latte with Croissant",6.50,3);
        Product setD= new Product("D. Latte with Muffin",7.00,3);
        Product setE= new Product("E. Espresso and Latte with Croissant and Muffin",11.00,1);
        productRepository.save(setA);
        productRepository.save(setB);
        productRepository.save(setC);
        productRepository.save(setD);
        productRepository.save(setE);


//        System.out.println("Started in Bootstrap");
//        System.out.println("Number of Products"+productRepository.count());
//        System.out.println(productRepository.findAll());
//        System.out.println("Number of Parts"+partRepository.count());
//        System.out.println(partRepository.findAll());

    }
}
