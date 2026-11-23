class ProductOfNumbers {
    private List<Integer> prefixProduct;

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            prefixProduct = new ArrayList<>();
            prefixProduct.add(1);
        } else {
            int last = prefixProduct.get(prefixProduct.size() - 1);
            prefixProduct.add(last * num);
        }
    }
    
    public int getProduct(int k) {
        if (k >= prefixProduct.size()) {
            return 0;
        }
        return prefixProduct.get(prefixProduct.size() - 1) / prefixProduct.get(prefixProduct.size() - 1 - k);
    }
}