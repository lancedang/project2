package com.ppdai.tutorial;

public abstract class StatisticAbstract { 
	public abstract DataDay getWindSpeedMinDay();

	public abstract DataDay getWindSpeedMaxDay();

	public abstract Sample getWindSpeedAverage();

	public abstract Sample getSolarRadiationAverage();

	public abstract DataDay getSolarRadiationMinDay();

	public abstract DataDay getSolarRadiationMaxDay();
}
