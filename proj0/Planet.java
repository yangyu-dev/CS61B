import java.lang.reflect.Array;

/**
 * Planet
 */
public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    static final double G = 6.67e-11; 
    
    public Planet(double xP, double yP, double xV,double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        p.xxPos = xxPos;
        p.yyPos = yyPos;
        p.xxVel = xxVel;
        p.yyVel = yyVel;
        p.mass = mass;
        p.imgFileName = imgFileName;
    }

    /** 
     * Usage:samh.calcDistance(rocinante);
     * Function: Calculate the distance between two Planets.
     */
    public double calcDistance(Planet p2) {
        Planet p1 = this;
        double dX, dY, d;
        dX = p1.xxPos - p2.xxPos;
        dY = p1.yyPos - p2.yyPos;
        d = Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));
        return d;
    }

    /**
     * Usage:samh.calcForceExertedBy(rocinante);
     * Funtion: Return a double describing the force exerted on this planet 
     *          by the given planet.
     */
    public double calcForceExertedBy(Planet p2) {
        Planet p1 = this;
        double force = 0;
        force = G * (p1.mass) * (p2.mass) / Math.pow((p1.calcDistance(p2)),2);
        return force;
    }

    /**
     * Usage:samh.calcForceExertedByX(rocinante);
     * Funtion:  Return the total force, these two methods describe the force 
     * exerted in the X and Y directions.
     */
    public double calcForceExertedByX(Planet p2) {
        Planet p1 = this;
        double forceX = 0;
        forceX = -p1.calcForceExertedBy(p2) * (p1.xxPos - p2.xxPos) / p1.calcDistance(p2);
        return forceX;
    }

    public double calcForceExertedByY(Planet p2) {
        Planet p1 = this;
        double forceY = 0;
        forceY = -p1.calcForceExertedBy(p2) * (p1.yyPos - p2.yyPos) / p1.calcDistance(p2);
        return forceY;
    }

    /**
     * Usage:samh.calcNetForceExertedByX(allPlanets);
     * Funtion: Take in an array of Planets and calculate the net X force 
     *          exerted by all planets in that array upon the current Planet.
     */
    public double calcNetForceExertedByX(Planet[] Planets) {
        Planet p1 = this;
        double nforceX = 0;
        for (int i = 0; i < Planets.length; i++) {
            if (!p1.equals(Planets[i])){
                nforceX = nforceX + p1.calcForceExertedByX(Planets[i]);
            }
        }
        return nforceX;
    }

    public double calcNetForceExertedByY(Planet[] Planets) {
        Planet p1 = this;
        double nforceY = 0;
        for (int i = 0; i < Planets.length; i++) {
            if (!p1.equals(Planets[i])){
                nforceY = nforceY + p1.calcForceExertedByY(Planets[i]);
            }
        }
        return nforceY;
    }


}