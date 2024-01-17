package com.gruposuperior.calidad.manofactura.dto;

import java.util.List;

public class ResponsePaginatedDTO<T> extends ResponseDTO<T> {
	
	private List<ResponseDTO<T>> elements;
	private int currentPage;
	private long totalElements;
	private long totalPages;
	
	public List<ResponseDTO<T>> getElements() {
		return elements;
	}
	public void setElements(List<ResponseDTO<T>> elements) {
		this.elements = elements;
	}
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
