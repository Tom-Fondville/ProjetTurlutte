package fr.epsi.turlutte;

import fr.epsi.turlutte.Repository.CategoryRepository;
import fr.epsi.turlutte.Repository.ProductRepository;
import fr.epsi.turlutte.common.model.Category;
import fr.epsi.turlutte.common.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TurlutteApplication {

    @Autowired
    CategoryRepository categoryRepository;

	@Autowired
	ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(TurlutteApplication.class, args);
    }

    @PostConstruct
    public void init() {
        var pecheAuGros = Category.builder().name("Pêche au gros").build();
        var pecheAuGrosMaisPasTrop = Category.builder().name("Pêche au gros mais pas trop").category(pecheAuGros).build();
		var pecheAvecDuFun = Category.builder().name("Pêche avec du fun").build();
        categoryRepository.save(pecheAuGros);
        categoryRepository.save(pecheAuGrosMaisPasTrop);
        categoryRepository.save(pecheAvecDuFun);

		var productFun = Product.builder().name("turlutte swag")
				.description("Une turlutte qui à du swag !")
				.price(25)
				.image("https://media.peche.com/src/images/news/articles/ima-image-30832.jpg")
				.category(pecheAvecDuFun).build();

		var productClassique = Product.builder().name("turlutte classique")
				.description("Une turlutte efficace")
				.price(5)
				.image("https://www.pacificpeche.com/dw/image/v2/BFMQ_PRD/on/demandware.static/-/Sites-pp-master-catalog/default/dwbda036d0/images/1/3/5/135132-a.jpg")
				.category(pecheAuGros).build();

		var productClassique2 = Product.builder().name("turlutte classique mais pas trop")
				.description("Une turlutte efficace mais pas trop")
				.price(5)
				.image("https://www.top-fishing.fr/images/articles/standard/turlutte-yamashita-toto-sutte-r-ws95lc-lazer-color-75mm-cwrs95sblo.jpg")
				.category(pecheAuGrosMaisPasTrop).build();

		productRepository.save(productClassique);
		productRepository.save(productClassique2);
		productRepository.save(productFun);
    }

}
