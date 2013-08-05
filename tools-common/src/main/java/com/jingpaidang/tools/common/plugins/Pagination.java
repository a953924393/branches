package com.jingpaidang.tools.common.plugins;

/**
 * The pagination class for paging.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 5/28/13
 */
public class Pagination {
    private int offset; // start number for each page
    private int pageSize; // capacity of a page
    private int pageNumber; // the current page number
    private int pageCount; // count of all pages
    private int totalCount; // count of all data for paging

    private boolean pagination = true; // whether paginating or not
    private boolean hasNextPage = false; // whether have next page or not
    private boolean hasPreviousPage = false; // whether have previous page or not

    private static final int DEFAULT_PAGE = 1; // the default current page number
    private static final int DEFAULT_PAGE_SIZE = 50; // the default capacity of each page

    /**
     * Constructors.
     */
    public Pagination() {
        this(DEFAULT_PAGE, DEFAULT_PAGE_SIZE);
    }

    public Pagination(int pageNumber) {
        this(pageNumber, DEFAULT_PAGE_SIZE);
    }

    public Pagination(int pageNumber, int pageSize) {
        setPageNumber(pageNumber);
        setPageSize(pageSize);
    }

    public int getOffset() {
        return offset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize <= 0) throw new IllegalArgumentException("pageSize must be positive integer!");
        this.pageSize = pageSize;
        resetOffset();
    }

    // reset the offset
    private void resetOffset() {
        offset = (pageNumber - 1) * pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        if (pageNumber <= 0) throw new IllegalArgumentException("pageNumber must be positive integer!");
        this.pageNumber = pageNumber;
        resetOffset();
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        setPageCount((int) Math.ceil((double) totalCount / (double) pageSize));
    }

    public boolean isPagination() {
        return pagination;
    }

    public void setPagination(boolean pagination) {
        this.pagination = pagination;
    }

    public boolean isHasNextPage() {
        hasNextPage = pageNumber < pageCount;
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isHasPreviousPage() {
        hasPreviousPage = (pageNumber - 1) > 0;
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }
}
