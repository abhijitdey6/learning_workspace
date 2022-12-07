package threads.executor;


import threads.domain.Product;
import threads.domain.ProductInfo;
import threads.domain.Review;
import threads.service.ProductInfoService;
import threads.service.ReviewService;
import static threads.util.LoggerUtil.log;
import static threads.util.CommonUtil.stopWatch;

import java.util.concurrent.*;

public class ProductServiceUsingExecutor {
    static ExecutorService executorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private ProductInfoService productInfoService;
    private ReviewService reviewService;

    public ProductServiceUsingExecutor(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
    }

    public Product retrieveProductDetails(String productId) throws ExecutionException, InterruptedException, TimeoutException {
        stopWatch.start();

        Future<ProductInfo> productInfoFuture = executorService.submit(()->productInfoService.retrieveProductInfo(productId));
        Future<Review> reviewFuture = executorService.submit(()->reviewService.retrieveReviews(productId));

        //ProductInfo productInfo = productInfoFuture.get();
        ProductInfo productInfo = productInfoFuture.get(2, TimeUnit.SECONDS);
        Review review = reviewFuture.get();

        stopWatch.stop();
        log("Total Time Taken : "+ stopWatch.getTime());
        return new Product(productId, productInfo, review);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ProductInfoService productInfoService = new ProductInfoService();
        ReviewService reviewService = new ReviewService();
        ProductServiceUsingExecutor productService = new ProductServiceUsingExecutor(productInfoService, reviewService);
        String productId = "ABC123";
        Product product = productService.retrieveProductDetails(productId);
        log("Product is " + product);
        executorService.shutdown();

    }
}
