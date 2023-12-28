package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private final InhousePartRepository inhousePartRepository;
    private List<Product> productList;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository=inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (partRepository.count()!=0 || productRepository.count()!=0){
            return;
        }

        Product setA= new Product("A. Espresso with Croissant",6.50,3);
        Product setB= new Product("B. Espresso with Muffin",7.00,3);
        Product setC= new Product("C. Latte with Croissant",8.50,3);
        Product setD= new Product("D. Latte with Muffin",9.00,3);
        Product setE= new Product("E. Espresso and Latte with Croissant and Muffin",15.50,1);
        productRepository.save(setA);
        productRepository.save(setB);
        productRepository.save(setC);
        productRepository.save(setD);
        productRepository.save(setE);


        InhousePart inhousePart = new InhousePart();
        inhousePart.setName("Cookie");
        inhousePart.setId(105);
        inhousePart.setInv(13);
        inhousePart.setPrice(2.50);
        inhousePart.setMinInv(1);
        inhousePart.setMaxInv(13);
        inhousePart.setPartId(1);
        inhousePartRepository.save(inhousePart);

        Set<Product> assProducts = new HashSet<>();

        OutsourcedPart outsourcedPart= new OutsourcedPart();
        outsourcedPart.setCompanyName("Vending Machine");
        outsourcedPart.setName("Espresso");
        outsourcedPart.setInv(5);
        outsourcedPart.setPrice(3.00);
        outsourcedPart.setId(100);
        outsourcedPart.setMinInv(1);
        outsourcedPart.setMaxInv(10);
        assProducts.add(setA);
        assProducts.add(setB);
        assProducts.add(setE);
        outsourcedPart.setProducts(assProducts);
        outsourcedPartRepository.save(outsourcedPart);
        assProducts.clear();

        outsourcedPart.setCompanyName("Vending Machine");
        outsourcedPart.setName("Latte");
        outsourcedPart.setInv(5);
        outsourcedPart.setPrice(5.00);
        outsourcedPart.setId(101);
        outsourcedPart.setMinInv(1);
        outsourcedPart.setMaxInv(10);
        assProducts.add(setC);
        assProducts.add(setD);
        assProducts.add(setE);
        outsourcedPart.setProducts(assProducts);
        outsourcedPartRepository.save(outsourcedPart);
        assProducts.clear();

        outsourcedPart.setCompanyName("Supermarket Bakery");
        outsourcedPart.setName("Croissaint");
        outsourcedPart.setInv(5);
        outsourcedPart.setPrice(3.50);
        outsourcedPart.setId(102);
        outsourcedPart.setMinInv(1);
        outsourcedPart.setMaxInv(12);
        assProducts.add(setA);
        assProducts.add(setC);
        assProducts.add(setE);
        outsourcedPart.setProducts(assProducts);
        outsourcedPartRepository.save(outsourcedPart);
        assProducts.clear();

        outsourcedPart.setCompanyName("Supermarket Bakery");
        outsourcedPart.setName("Muffin");
        outsourcedPart.setInv(5);
        outsourcedPart.setPrice(4.00);
        outsourcedPart.setId(103);
        outsourcedPart.setMinInv(1);
        outsourcedPart.setMaxInv(12);
        assProducts.add(setB);
        assProducts.add(setD);
        assProducts.add(setE);
        outsourcedPart.setProducts(assProducts);
        outsourcedPartRepository.save(outsourcedPart);
        assProducts.clear();

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



//        System.out.println("Started in Bootstrap");
//        System.out.println("Number of Products"+productRepository.count());
//        System.out.println(productRepository.findAll());
//        System.out.println("Number of Parts"+partRepository.count());
//        System.out.println(partRepository.findAll());

    }
}
