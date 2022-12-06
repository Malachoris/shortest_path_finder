package com.assignment.nl22w.game.impl;

import com.assignment.nl22w.game.interfaces.Matrix;
import com.assignment.nl22w.game.interfaces.PathFinder;
import com.assignment.nl22w.game.interfaces.Reader;
import com.assignment.nl22w.game.interfaces.Validator;
import com.assignment.nl22w.game.models.ForestBlock;
import com.assignment.nl22w.game.interfaces.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class GameImpl implements Game {

	// Calls all objects as services, knows how to validate, create matrix.
	// Service is like a worker, model is like one object (like a bag)
	// ENUM is variations of constants with clear naming
	@Autowired
	private Validator forestValidator;
	@Autowired
	private Reader fileReader;
	@Autowired
	private Matrix matrix;
	@Autowired
	private PathFinder finder;

	// P.S. Dependency Injection makes loose coupling of components and moves management of components to containers
	// loose coupling makes code more manageable by creating common interface for other classes that uses similar methods
	// loose coupling with Spring is another level of loose coupling
	// Dependency injection is a pattern we can use to implement Inversion of Control
	// “injecting” objects into other objects, is done by an assembler rather than by the objects themselves

	@Override
	public int escapeFromTheWoods(Resource resource) throws IOException {
		String fileData = this.fileReader.read(resource);
		if (!this.forestValidator.isValid(fileData)) return 0;

		matrix.initialize(fileData);
		List<ForestBlock> path = this.finder.findPath(matrix);
		return this.finder.stepCount(path);
	}
}

