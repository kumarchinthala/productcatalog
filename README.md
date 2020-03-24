Build the application

##requirements -

gradle-6.2.2

Java version: 1.8.0_101

##Build App -

gradlew build

##To start the application

To start the application we need to run to services


##search product by type

http://localhost:2222/products/{productType}

http://localhost:2222/products/Laptops

Response Sample { "id": 2, "name": "Lenovo", "type": "Laptops", "price": 33862.1 }

##Search price by product

http://localhost:9091/product/price/650.23

Response [{"id":0,"name":"arrow","type":"shirt","price":650.23,"color":"white","size":"XL"}]

##Search color by product
http://localhost:9091/product/color/white

[{"id":0,"name":"arrow","type":"shirt","price":650.23,"color":"white","size":"XL"}]
##Search size by product
http://localhost:9091/product/size/XL

[{"id":0,"name":"arrow","type":"shirt","price":650.23,"color":"white","size":"XL"}]

##Search name by product
http://localhost:9091/product/name/polo
[{"id":1,"name":"polo","type":"shirt","price":650.23,"color":"black","size":"XL"}]

##Save Product

http://localhost:9091/product/save

Request Payload :{ "name": "arrow", "type": "shirt", price":650.23,"color":"white","size":"XL"             },
	 

Response: {
    "id": 5,
    "name": "arrow",
    "type": "shirt",
    "price": 650.23,
    "color": "white",
    "size": "XL"
}

##Delete Product

http://localhost:9091/product/delete/{productId}

http://localhost:9091/product/delete/0

Response  :0