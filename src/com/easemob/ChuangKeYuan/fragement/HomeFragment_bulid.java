package com.easemob.ChuangKeYuan.fragement;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.easemob.ChuangKeYuan.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class HomeFragment_bulid extends Fragment {

	private ViewPager mViewPager; // android-support-v4中的滑动组件
	private List<ImageView> imageViews; // 滑动的图片集合

	private String[] titles; // 图片标题
	private int[] imageResId; // 图片ID
	private List<View> dots; // 图片标题正文的那些点

	private TextView tv_title;
	private int currentItem = 0; // 当前图片的索引号

	private ScheduledExecutorService scheduledExecutorService;
	// 切换当前显示的图片
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			mViewPager.setCurrentItem(currentItem);// 切换当前显示的图片
		}
	};

	private ListView mListView;
	//定义一个动态数组
	ArrayList<HashMap<String, Object>> listItem;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home_child, null);

		initListView(view);

		imageResId = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e};
		titles = new String[imageResId.length];
		titles[0] = "巩俐不低俗，我就不能低俗";
		titles[1] = "扑树又回来啦！再唱经典老歌引万人大合唱";
		titles[2] = "揭秘北京电影如何升级";
		titles[3] = "乐视网TV版大派送";
		titles[4] = "热血屌丝的反杀";

		imageViews = new ArrayList<ImageView>();

		// 初始化图片资源
		for (int i = 0; i < imageResId.length; i++) {
			ImageView imageView = new ImageView(getActivity().getApplicationContext());
			imageView.setImageResource(imageResId[i]);
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageViews.add(imageView);
		}

		dots = new ArrayList<View>();
		dots.add(view.findViewById(R.id.v_dot0));
		dots.add(view.findViewById(R.id.v_dot1));
		dots.add(view.findViewById(R.id.v_dot2));
		dots.add(view.findViewById(R.id.v_dot3));
		dots.add(view.findViewById(R.id.v_dot4));

		tv_title = (TextView) view.findViewById(R.id.tv_title);
		tv_title.setText(titles[0]);

		mViewPager = (ViewPager) view.findViewById(R.id.vp_fragment_viewpager);
		mViewPager.setAdapter(new MyAdapter());// 设置填充ViewPager页面的适配器
		// 设置一个监听器，当ViewPager中的页面改变时调用
		mViewPager.setOnPageChangeListener(new MyPageChangeListener());
		return view;
	}

	private void initListView(View view) {
		mListView = (ListView) view.findViewById(R.id.lv);
		mListView.setAdapter(new ListViewAdapter(getContext()));

		//为ListView添加点击事件
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//在LogCat中输出信息
				Log.v("MyListViewBase", "你点击了ListView条目" + position);
			}
		});
	}

	//添加一个得到数据的方法，方便使用
	private ArrayList<HashMap<String, Object>> getDate() {

		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		//为动态数组添加数据
		for (int i = 0; i < 30; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ItemTitle", "第" + i + "行");
			map.put("ItemText", "这是第" + i + "行");
			listItem.add(map);
		}
		return listItem;
	}

	private class ListViewAdapter extends BaseAdapter {

		//得到一个LayoutInfalter对象用来导入布局
		private LayoutInflater mInflater;

		//构造函数
		public ListViewAdapter(Context context) {
			this.mInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			//返回数组的长度
			return getDate().size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = mInflater.inflate(R.layout.fragment_listview_item, null);
				 //得到各个控件的对象
				holder.title = (TextView) convertView.findViewById(R.id.title);
				holder.text = (TextView) convertView.findViewById(R.id.des);
				//绑定ViewHolder对象
				convertView.setTag(holder);
			} else {
				//取出ViewHolder对象
				holder = (ViewHolder) convertView.getTag();
				//设置TextView显示的内容，即我们存放在动态数组中的数据
				holder.title.setText(getDate().get(position).get("ItemTitle").toString());
				holder.text.setText(getDate().get(position).get("ItemText").toString());
			}
			return convertView;
		}
	}
		//存放控件
		public final class ViewHolder {
			public TextView title;
			public TextView text;
			public Button bt;
		}

		@Override
		public void onStart() {
			scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
			// 当Activity显示出来后，每两秒钟切换一次图片显示
			scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 2, TimeUnit.SECONDS);
			super.onStart();
		}

		@Override
		public void onStop() {
			// 当Activity不可见的时候停止切换
			scheduledExecutorService.shutdown();
			super.onStop();
		}

		/**
		 * 换行切换任务
		 */
		private class ScrollTask implements Runnable {

			public void run() {
				synchronized (mViewPager) {
					System.out.println("currentItem: " + currentItem);
					currentItem = (currentItem + 1) % imageViews.size();
					handler.obtainMessage().sendToTarget(); // 通过Handler切换图片
				}
			}

		}

		/**
		 * 当ViewPager中页面的状态发生改变时调用
		 */
		private class MyPageChangeListener implements ViewPager.OnPageChangeListener {
			private int oldPosition = 0;

			/**
			 * This method will be invoked when a new page becomes selected.
			 * position: Position index of the new selected page.
			 */
			public void onPageSelected(int position) {
				currentItem = position;
				tv_title.setText(titles[position]);
				dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
				dots.get(position).setBackgroundResource(R.drawable.dot_focused);
				oldPosition = position;
			}

			public void onPageScrollStateChanged(int arg0) {

			}

			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}
		}

		/**
		 * 填充ViewPager页面的适配器
		 */
		private class MyAdapter extends PagerAdapter {

			@Override
			public int getCount() {
				return imageResId.length;
			}

			@Override
			public Object instantiateItem(View arg0, int arg1) {
				((ViewPager) arg0).addView(imageViews.get(arg1));
				return imageViews.get(arg1);
			}

			@Override
			public void destroyItem(View arg0, int arg1, Object arg2) {
				((ViewPager) arg0).removeView((View) arg2);
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public void restoreState(Parcelable arg0, ClassLoader arg1) {

			}

			@Override
			public Parcelable saveState() {
				return null;
			}

			@Override
			public void startUpdate(View arg0) {

			}

			@Override
			public void finishUpdate(View arg0) {

			}
		}
	}

