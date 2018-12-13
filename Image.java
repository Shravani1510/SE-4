package assignment;

import java.io.*;
import java.util.List;
class Image {

	byte[] data;
	int w, h;

	Image( int _w, int _h ) { w = _w; h = _h; data = new byte[w*h*3]; }

	void set( int x, int y, int val ) {
		int offset = (y*w + x) * 3;
		data[offset+0] = (byte)((val & 0x00FF0000) >> 16);
		data[offset+1] = (byte)((val & 0x0000FF00) >>  8);
		data[offset+2] = (byte)((val & 0x000000FF) >>  0);
	}

	void write( String filename ) throws FileNotFoundException,IOException {
		FileOutputStream stream = new FileOutputStream(filename); // +".ppm");
		stream.write(new String("P6 "+w+" "+h+" 255\n").getBytes());
		stream.write(data);
		stream.close();
	}

	void trace( List<Entity> entities ) {
		int size = entities.size();
		for(int y =0 ; y<h; y++) {
			for(int x=0; x<w;x++) {
				float min = Float.MAX_VALUE;
				this.set(x, y, 0);
				for(int i =0; i<size; i++) {
					Entity En = entities.get(i);
					Vec3D ray = new Vec3D((float)(x-w/2+.5), (float)(y-h/2+.5), 1615);
					Vec3D best = En.intersect(ray);
					if(En.intersect(ray)!= null) {
						float best1 = best.len();
					if(best1< min) {
						this.set(x, y, En.color());
					}
					
				}
			}
		}

	}
			
		
		// TODO: fill me in
		
		
			
	}}
		

	

