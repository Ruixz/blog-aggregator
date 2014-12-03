package com.rui.blog.service;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.rui.blog.entity.Item;
import com.rui.blog.exception.RssException;

public class RssServiceTest {
	
	private RssService rssService;

	@Before
	public void setUp() throws Exception {
		rssService = new RssService();
	}

	@Test
	public void testGetItemsFile() throws RssException {
		List<Item> items = rssService.getItems(new File("test-rss/ruan.xml"));
		assertEquals(8, items.size());
		Item firstItem = items.get(0);
		assertEquals("数据可视化：基本图表", firstItem.getTitle());
		assertEquals("29 11 2014 01:14:19", new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstItem.getPublishedDate()));
	}

}
