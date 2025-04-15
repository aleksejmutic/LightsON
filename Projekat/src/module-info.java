/**
 * 
 */
/**
 * 
 */
module LightsOn {
	requires java.sql; 
	requires gson; 
	 opens model to gson;
	requires java.desktop;
	requires JTattoo;
	requires Localization;
	exports model;
	requires itextpdf;
	requires javadocking;
}