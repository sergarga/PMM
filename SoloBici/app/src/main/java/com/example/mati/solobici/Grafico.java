package com.example.mati.solobici;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class Grafico {
	private Drawable drawable; // Imagen que dibujaremos
	private double posX, posY; // Posici�n en la pantalla
	private double incX, incY; // Velocidad de desplazamiento
	private int angulo, rotacion;// �ngulo y velocidad rotaci�n
	private int ancho, alto; // Dimensiones de la imagen
	private int radioColision; // Determinar si chocamos 
	// Vista donde dibujamos el gr�fico
	private View view;
	// Para determinar el espacio a borrar
	public static final int MAX_VELOCIDAD = 20;

	//Inicializamos los atributos de esta clase
	public Grafico(View view, Drawable drawable) {
		this.view = view;
		this.drawable = drawable;
		ancho = drawable.getIntrinsicWidth()*2;
		alto = drawable.getIntrinsicHeight()*2;
		radioColision = (alto + ancho) / 4;
	}

	//Dibujamos el gr�fico en su posici�n actual
	public void dibujaGrafico(Canvas canvas) {
		canvas.save();
		int x = (int) (posX + ancho / 2);
		int y = (int) (posY + alto / 2);
		canvas.rotate((float) angulo, (float) x, (float) y);
		drawable.setBounds((int) posX, (int) posY, (int) posX + ancho,
				(int) posY + alto);
		drawable.draw(canvas);
		canvas.restore();
		//Calculo �rea donde no podr�n solaparse/chocar
		//otros gr�ficos con este
		int rInval = (int) distanciaE(0, 0, ancho, alto) / 2 + MAX_VELOCIDAD;
		view.invalidate(x - rInval, y - rInval, x + rInval, y + rInval);
	};

	//Correccion posici�n si el gr�fico sale de la pantalla
	//En estos casos aparece por el otro lado de la pantalla
	public void incrementaPos() {
		posX += incX;
		// Si salimos de la pantalla, corregimos posici�n
		if (posX < -ancho / 2) {
			posX = view.getWidth() - ancho / 2;
		}
		if (posX > view.getWidth() - ancho / 2) {
			posX = -ancho / 2;
		}
		posY += incY;
		// Si salimos de la pantalla, corregimos posici�n
		if (posY < -alto / 2) {
			posY = view.getHeight() - alto / 2;
		}
		if (posY > view.getHeight() - alto / 2) {
			posY = -alto / 2;
		}
		angulo += rotacion; // Actualizamos �ngulo
	}

	//Nos devuelve la distancia entre dos objetos Grafico
	public double distancia(Grafico g) {
		return distanciaE(posX, posY, g.posX, g.posY);
	}

	//Nos devuelve si se produce o no colisi�n 
	public boolean verificaColision(Grafico g) {
		return (distancia(g) < (radioColision + g.radioColision));
	}

	public static double distanciaE(double x, double y, double x2, double y2) {
		return Math.sqrt((x - x2) * (x - x2) + (y - y2) * (y - y2));
	}

    public void setIncX(Double incremento){
        this.incX = incremento;
    }

    public void setIncY(Double incremento){
        this.incY = incremento;
    }

    public void setAngulo(int angulo){
        this.angulo = angulo;
    }

    public void setRotacion(int rotacion){
        this.rotacion = rotacion;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public int getAncho() {
        return ancho;
    }

    public double getIncX() {
        return incX;
    }

    public void setIncX(double incX) {
        this.incX = incX;
    }

    public double getIncY() {
        return incY;
    }

    public void setIncY(double incY) {
        this.incY = incY;
    }

    public int getAngulo() {
        return angulo;
    }

    public static int getMaxVelocidad() {
        return MAX_VELOCIDAD;
    }

    public int getAlto() {
        return alto;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }
}
