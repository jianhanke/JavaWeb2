package cn.itcast.bookStore.web.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookStore.domain.Order;
import cn.itcast.bookStore.service.OrderService;

public class FindOrderByManyConditionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String receiverName = request.getParameter("receiverName");

		OrderService service = new OrderService();
		List<Order> orders = service.findOrderByManyCondition(id, receiverName);

		request.setAttribute("orders", orders);

		request.getRequestDispatcher("/admin/orders/list.jsp").forward(request,
				response);
	}

}
