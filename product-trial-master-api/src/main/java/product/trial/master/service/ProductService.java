package product.trial.master.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.trial.master.dto.ProductDTO;
import product.trial.master.mapper.ProductMapper;
import product.trial.master.model.Product;
import product.trial.master.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    public List<ProductDTO> getAllProducts() {
        List<Product> products =  productRepository.findAll();
        return  products.stream()
                .map(productMapper::productToProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id); // Retrieve product by ID
        return productOptional.map(productMapper::productToProductDTO).orElse(null); // Convert to DTO if found
    }

    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.productDTOToProduct(productDTO); // Convert DTO to entity
        Product savedProduct = productRepository.save(product); // Save the product
        return productMapper.productToProductDTO(savedProduct); // Return the saved product as DTO
    }
}
