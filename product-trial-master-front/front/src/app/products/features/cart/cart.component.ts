import { Component, OnInit } from '@angular/core';
import { Product } from "app/products/data-access/product.model";
import { ProductsService } from "app/products/data-access/products.service";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  standalone: true
})
export class CartComponent implements OnInit {
  cart: Product[] = [];

  constructor(private productsService: ProductsService) {}

  ngOnInit(): void {
    this.cart = this.productsService.getCart();
  }

  getTotalItems(): number {
    return this.productsService.getCart().length;
  }
}
