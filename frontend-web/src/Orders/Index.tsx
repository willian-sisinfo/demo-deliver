import React, { useEffect, useState } from "react";
import { fetchProducts } from "../Api";
import ProductsList from "./ProductsList";
import StepsHeader from "./StepsHeader";
import './styles.css';
import { Product } from "./Types";
 
function Orders() {

    const [products, setProducts] = useState<Product[]>([]);

    useEffect(() => {
        fetchProducts()
        .then(response => setProducts(response.data))
        .catch(Error => console.log(Error))
    }, []);

    return (
        <div className="orders-container">
            <StepsHeader />
            <ProductsList products={products} />
        </div>
        
    )
}
export default Orders;