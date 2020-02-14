package com.lxisoft.Models;

import java.util.Comparator;
import com.lxisoft.Domain.*;
public class SortByNumber implements Comparator<Contact>
{
	public int compare(Contact one,Contact two)
	{
		return (one.getNo()).compareTo(two.getNo());
	}
}