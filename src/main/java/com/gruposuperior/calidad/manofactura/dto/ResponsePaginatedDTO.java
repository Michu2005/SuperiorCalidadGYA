package com.gruposuperior.calidad.manofactura.dto;

public class ResponsePaginatedDTO<T> extends ResponseDTO<T> {
	
	private int currentPage;
	private long totalElements;
	private long totalPages;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}
	
	

}
