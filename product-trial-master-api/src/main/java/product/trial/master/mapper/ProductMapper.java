package product.trial.master.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import product.trial.master.dto.ProductDTO;
import product.trial.master.model.Product;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToProductDTO(Product product);
    Product productDTOToProduct(ProductDTO productDTO);
}
