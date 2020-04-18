package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

import java.util.Random;

@Service
public class ProductService {

	/**
	 * propagation =
	 * REQUIRED(default)
	 * REQUIRES_NEW
	 * MANDATORY
	 * NEVER
	 * SUPPORTS
	 * NOT_SUPPORTED
	 * NESTED
	 * <p>
	 * a() ---> b(a()) : End of the transaction is at the end of b() method.
	 */


	@Autowired
	ProductRepository productRepository;

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void addTenProducts() {
		Random random = new Random();
		random.ints(10)
				.forEach(i -> {
					productRepository.addProduct("Produsul-" + i, random.nextDouble());
					if (i % 10 == 0) throw new RuntimeException(":(");
				});

	}
}
