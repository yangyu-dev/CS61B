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
     * Funtion: Return a double describing the force exerted on this planet by the given planet.
     */
    public double calcForceExertedBy(Planet p2) {
        Planet p1 = this;
        double force;
        force = G * (p1.mass) * (p2.mass) / Math.pow((p1.calcDistance(p2)),2);
        return force;
    }


}