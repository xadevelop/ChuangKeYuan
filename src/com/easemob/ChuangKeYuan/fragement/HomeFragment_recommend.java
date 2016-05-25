package com.easemob.ChuangKeYuan.fragement;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.easemob.ChuangKeYuan.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Say GoBay on 2016/5/23.
 */
public class HomeFragment_recommend extends Fragment {
    /**
     * ViewPager
     */
    private ViewPager mViewPager;
    // 滑动的图片集合
    private List<ImageView> imageViews;
    // 图片标题
    private String[] titles;
    // 图片ID
    private int[] imageResId;
    // 图片标题正文的那些点
    private List<View> dots;

    private TextView tv_title;
    // 当前图片的索引号
    private int currentItem = 0;

    private ScheduledExecutorService scheduledExecutorService;
    // 切换当前显示的图片
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            // 切换当前显示的图片
            mViewPager.setCurrentItem(currentItem);
        }
    };
    //GridView
    private GridView mGridView;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;

    // 图片封装为一个数组
    private int[] icon = { R.drawable.gv_1, R.drawable.gv_2,
            R.drawable.gv_3, R.drawable.gv_4, R.drawable.gv_5,
            R.drawable.gv_6, R.drawable.gv_7, R.drawable.gv_8,
            R.drawable.gv_9, R.drawable.gv_10 };
    //文字封装为一个数组
    private String[] text = { "博览群书","学富五车","博闻强识","博学多才","满腹经纶","博古通今","汗牛充栋","才高八斗","手不释卷","孜孜不倦"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_child, null);
        //初始化GridView
        initGridView(view);
        //ViewPager
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
        // 设置填充ViewPager页面的适配器
        mViewPager.setAdapter(new MyAdapter());
        // 设置一个监听器，当ViewPager中的页面改变时调用
        mViewPager.setOnPageChangeListener(new MyPageChangeListener());
        return view;
    }

    /**
     * 初始化GridView
     */
    private void initGridView(View view) {
        mGridView = (GridView) view.findViewById(R.id.gv);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.image,R.id.text};
        sim_adapter = new SimpleAdapter(getContext(), data_list, R.layout.fragment_gridview_item, from, to);
        //配置适配器
        mGridView.setAdapter(sim_adapter);
    }

    public List<Map<String, Object>> getData(){
        //cion和text的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", text[i]);
            data_list.add(map);
        }
        return data_list;
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
