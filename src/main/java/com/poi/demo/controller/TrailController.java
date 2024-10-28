package com.poi.demo.controller;

import com.poi.demo.dto.ResourceIdDto;
import com.poi.demo.dto.Trail;
import com.poi.demo.exception.ResourceNotFoundException;
import com.poi.demo.service.TrailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/api/trails")
public class TrailController extends BaseController
{
	private final TrailService trailService;

	public TrailController(final TrailService trailService)
	{
		this.trailService = trailService;
	}

	@GetMapping
	public HttpEntity<Page<Trail>> find(@RequestParam(required = false, name = "class") String clazz,
										@RequestParam(required = false) String bikeTrail,
										@PageableDefault(size = 20) Pageable pageable)
	{
		final Page<Trail> trails = trailService.getAll(pageable);
		return ResponseEntity.ok(trails);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Trail> getById(@PathVariable final String id)
	{
		final Optional<Trail> dto = trailService.get(id);
		return dto.map(body -> ResponseEntity.ok().body(body)).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@PostMapping
	public ResponseEntity<ResourceIdDto> create(@RequestBody @Valid final Trail trail)
	{
		final String id = trailService.create(trail);
		return ResponseEntity.created(buildLocationHeader(id)).body(ResourceIdDto.of(id));
	}

}
