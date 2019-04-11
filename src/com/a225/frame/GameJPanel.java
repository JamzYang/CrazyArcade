package com.a225.frame;

import java.awt.Graphics;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;

import com.a225.model.manager.ElementManager;
import com.a225.model.vo.SuperElement;

/**
 * 
 * @author Jenson
 * 窗体容器：画板类
 */
public class GameJPanel extends JPanel implements Runnable{
	
//	显示画板内容，绘画
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//前动画
		gameRuntime(g);
		//衔接动画
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint(); //每隔100毫秒刷新画板
		}
	}
	
	//展示元素管理器中所有的元素
	public void gameRuntime(Graphics g) {
		Map<String, List<SuperElement>> map = ElementManager.getManager().getMap();
		Set<String> set = map.keySet();
		for(String key:set) {
			List<SuperElement> list = map.get(key);
			for(int i=0; i<list.size(); i++) {
				list.get(i).showElement(g);
			}
		}
	}
	

}
