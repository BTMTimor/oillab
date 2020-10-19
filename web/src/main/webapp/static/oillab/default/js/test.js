
function testCarousel() {
    let indexCarousel = Carousel.me.indexCarousels();
    console.log("indexCarousel: ", indexCarousel);

    let productCarousel = Carousel.me.productCarousels();
    console.log("productCarousel: ", productCarousel);
}

function testModular() {
    let navs = Modular.me.navs();
    console.log("navs: ", navs);

    let indexContent = Modular.me.indexModular();
    console.log("indexContent: ", indexContent);

    let aboutContent = Modular.me.aboutModular();
    console.log("aboutContent: ", aboutContent);

}

function printProducts(categoryId, productTypeId){
    let productData = Product.me.products(categoryId, productTypeId);
    // console.log("productData: ", productData);

    let productList = productData["data"]["main"];
    if (productList.length > 0) {
        for (let i in productList) {
            console.log("product: ", productList[i]);
        }
    }
}

function printProductType(categoryId, printfProducts=false){
    let productTypeData = ProductType.me.types(categoryId);
    // console.log("productTypeData: ", productTypeData);

    let productTypeList = productTypeData["data"]["main"];
    if (productTypeList.length > 0) {
        for (let i in productTypeList) {
            let productType = productTypeList[i];
            console.log("productType: ", productType);

            if (printfProducts) printProducts(categoryId, productType.id);
        }
    }
}

function printProductCategory(categoryId, printfProductTypes=false, printfProducts=false){
    // let categoryData = ProductCategoryDao.me.getById(categoryId);

    if (printfProductTypes) printProductType(categoryId, printfProducts);
}

function testProduct() {
    let categoryData = ProductCategory.me.category();
    // console.log("categoryData: ", categoryData);

    let categoryList = categoryData["data"]["main"];
    if (categoryList.length > 0){
        for (let i in categoryList) {
            let category = categoryList[i];
            console.log("category: ", category);

            printProductType(category.id, true, true);

            console.log("\n\n");
        }
    }
}

// 启动测试
function test() {
    testCarousel();
    // testModular();
    // testProduct();
    console.log(testVar);
}