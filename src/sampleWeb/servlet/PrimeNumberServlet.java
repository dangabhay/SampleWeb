package sampleWeb.servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class PrimeNumberServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1886818723097195040L;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		long seed=0, count=0;
		try {
			seed = Long.parseLong(request.getParameter("seed"));
			count = Long.parseLong(request.getParameter("count"));
		} catch (NumberFormatException ex) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		if (seed < 0 || count < 1)
			request.getRequestDispatcher("error.jsp").forward(request, response);
		request.setAttribute("primesList", getPrimesList(seed, count));
		request.getRequestDispatcher("primeNoView.jsp").forward(request, response);
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	
	private static List<Long> getPrimesList(long seed, long count)
	{
		return LongStream.iterate(seed, i->i+1).filter(PrimeNumberServlet::checkPrime).limit(count).boxed().collect(Collectors.toList());
	}
	
	private static boolean checkPrime(long num)
	{
		if (num == 0 || num == 1) return false;
		else if (num == 2) return true;
		for (long i=2; i*i<=num; i++)
			if (num%i==0)
				return false;
		return true;
	}
}
