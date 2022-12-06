package com.assignment.nl22w.game.impl;

import com.assignment.nl22w.game.Game;
import com.assignment.nl22w.game.solution.ForestBuilder;
import com.assignment.nl22w.game.solution.ForestPathFinder;
import com.assignment.nl22w.game.solution.ForestValidator;
import com.assignment.nl22w.game.solution.TextFileReader;
import com.assignment.nl22w.game.solution.interfaces.Matrix;
import com.assignment.nl22w.game.solution.interfaces.PathFinder;
import com.assignment.nl22w.game.solution.interfaces.Reader;
import com.assignment.nl22w.game.solution.interfaces.Validator;
import com.assignment.nl22w.game.solution.models.ForestBlock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class GameImpl implements Game {
	@Autowired
	private Validator forestValidator;
	@Autowired
	private Reader fileReader;
	@Autowired
	private Matrix matrix;
	@Autowired
	private PathFinder finder;

	// Here should be dependency injection in the future :)
	//* DI makes loose coupling of components and moves management of components to containers
	//* loose coupling makes code more manageable by creating common interface for other classes that uses similar methods
	//* loose coupling with Spring is another level of loose coupling
	//* Dependency injection is a pattern we can use to implement Inversion of Control
	//* “injecting” objects into other objects, is done by an assembler rather than by the objects themselves
	public GameImpl() {
		this.forestValidator = new ForestValidator();
		this.fileReader = new TextFileReader();
		this.matrix = new ForestBuilder();
		this.finder = new ForestPathFinder();
	}

	@Override
	public int escapeFromTheWoods(Resource resource) throws IOException {
		String fileData = this.fileReader.read(resource);
		if (!this.forestValidator.isValid(fileData)) return 0;

		matrix.initialize(fileData);
		List<ForestBlock> path = this.finder.findPath(matrix);
		return this.finder.stepCount(path);
	}
}

