package com.velociter.ems.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.velociter.hibernate.component.songdetail.Song;

/**
 * Servlet implementation class SongDetailsServlet
 */
//@WebServlet("/SongDetailsServlet")
public class SongDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String songName = request.getParameter("songName");
		String songType = request.getParameter("songType");
		String duration = request.getParameter("songDur");
		String singer1Name = request.getParameter("singerName1");
		String singer2Name = request.getParameter("singerName2");
		String writerName = request.getParameter("writerName");

		Song song = new Song();
		
		song.setSongName(songName);
		song.setSongType(songType);
		song.setSongDuration(duration);
		song.getSinger().setSingerName(singer1Name);
		song.getSinger().setSecondSingerName(singer2Name);
		song.getSinger().setWriterName(writerName);
//		 out.print(songName+" "+songType+" "+duration+" "+singer1Name+" "+singer2Name+" "+writerName);
		Session session = null;
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			session = sf.openSession();
			session.save(song);
			Transaction tx = session.beginTransaction();
			tx.commit();
			out.print("SongDetail Inserted Succesfully");
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			rd.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}
}