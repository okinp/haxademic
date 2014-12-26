package com.haxademic.core.image;

import java.util.ArrayList;

import processing.core.PGraphics;
import processing.core.PImage;

import com.haxademic.core.draw.util.DrawUtil;

public class MotionBlurPGraphics {
	
	int _blurFrames = 1;
	protected ArrayList<PImage> _pastFrames;

	public MotionBlurPGraphics(int frames) {
		_blurFrames = frames;
		_pastFrames = new ArrayList<PImage>();
	}
	
	public void updateToCanvas(PGraphics pg, PGraphics canvas) {
		// save current frame to buffer
		_pastFrames.add(pg.get());
		if(_pastFrames.size() > _blurFrames) {
			_pastFrames.remove(0);
		}
		
		// draw all frames to screen
		for (int f=0; f < _pastFrames.size(); f++) {
			float alpha = (f+1f) / _pastFrames.size();
			PImage pastFrame = _pastFrames.get(f);
			DrawUtil.setPImageAlpha(canvas, alpha);
			canvas.image(pastFrame, 0, 0);
		}

	}
}