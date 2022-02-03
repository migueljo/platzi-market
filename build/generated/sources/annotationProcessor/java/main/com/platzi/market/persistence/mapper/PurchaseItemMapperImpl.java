package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurchaseItem;
import com.platzi.market.persistence.entity.ComprasProducto;
import com.platzi.market.persistence.entity.ComprasProductoPK;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-02T18:23:45-0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.3.jar, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class PurchaseItemMapperImpl implements PurchaseItemMapper {

    @Override
    public PurchaseItem toPurchaseItem(ComprasProducto producto) {
        if ( producto == null ) {
            return null;
        }

        PurchaseItem purchaseItem = new PurchaseItem();

        Integer idProducto = productoIdIdProducto( producto );
        if ( idProducto != null ) {
            purchaseItem.setProductId( idProducto );
        }
        if ( producto.getCantidad() != null ) {
            purchaseItem.setQuantity( producto.getCantidad() );
        }
        if ( producto.getEstado() != null ) {
            purchaseItem.setActive( producto.getEstado() );
        }
        if ( producto.getTotal() != null ) {
            purchaseItem.setTotal( producto.getTotal() );
        }

        return purchaseItem;
    }

    @Override
    public ComprasProducto toComprasProducto(PurchaseItem item) {
        if ( item == null ) {
            return null;
        }

        ComprasProducto comprasProducto = new ComprasProducto();

        comprasProducto.setId( purchaseItemToComprasProductoPK( item ) );
        comprasProducto.setCantidad( item.getQuantity() );
        comprasProducto.setEstado( item.isActive() );
        comprasProducto.setTotal( item.getTotal() );

        return comprasProducto;
    }

    private Integer productoIdIdProducto(ComprasProducto comprasProducto) {
        if ( comprasProducto == null ) {
            return null;
        }
        ComprasProductoPK id = comprasProducto.getId();
        if ( id == null ) {
            return null;
        }
        Integer idProducto = id.getIdProducto();
        if ( idProducto == null ) {
            return null;
        }
        return idProducto;
    }

    protected ComprasProductoPK purchaseItemToComprasProductoPK(PurchaseItem purchaseItem) {
        if ( purchaseItem == null ) {
            return null;
        }

        ComprasProductoPK comprasProductoPK = new ComprasProductoPK();

        comprasProductoPK.setIdProducto( purchaseItem.getProductId() );

        return comprasProductoPK;
    }
}
