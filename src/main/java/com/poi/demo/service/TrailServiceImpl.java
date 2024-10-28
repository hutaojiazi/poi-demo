package com.poi.demo.service;

import com.poi.demo.dto.Trail;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@Slf4j
public class TrailServiceImpl implements TrailService
{
	private final List<Trail> allTrails = new ArrayList<>();

	public TrailServiceImpl()
	{

	}

	@Override
	@Transactional(readOnly = true)
	public Page<Trail> getAll(final Pageable pageable)
	{
		return new PageImpl<>(allTrails);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Trail> get(String id)
	{
		return allTrails.stream().filter(trail -> StringUtils.equals(id, String.valueOf(trail.getFid()))).findFirst();
	}

	@Override
	@Transactional
	public String create(final Trail trail)
	{
		// TODO: add implementation
		return UUID.randomUUID().toString();
	}

	@Override
	public void importFromCsv(String csvFile) {
		try (Stream<String> csvLines = Files.lines(Paths.get(ClassLoader.getSystemResource(csvFile).toURI())))
		{
			final List<Trail> trails = csvLines
					.skip(1) //Skips the header
					.map(this::buildTrail)
					.toList();

			allTrails.addAll(trails);
		}
		catch (IOException e)
		{
			log.error("Could not find file {}", csvFile, e);
		}
		catch (URISyntaxException e)
		{
			log.error("Invalid file location {}", csvFile, e);
		}
	}

	private Trail buildTrail(final String line)
	{
		final String[] values = line.split(",");

		return Trail.builder()
				.fid(Long.parseLong(values[0]))
				.address(values[8])
				.build();
	}

}
