package com.hvillanueva.tarea.micro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.hvillanueva.tarea.utils.CollectionUtils.streamOf;
import static java.util.Collections.list;

@Controller
@RequestMapping("headers")
public class MicroController {

    @GetMapping
    public @ResponseBody Map<String, List<String>> get(HttpServletRequest request){
        return streamOf(request.getHeaderNames())
               .collect(Collectors.<String, String, List<String>>toMap(
                       name -> name,
                       name -> list(request.getHeaders(name))));
    }

    @GetMapping(params = "q")
    public @ResponseBody Map<String, Optional<List<String>>> get(HttpServletRequest request, @RequestParam List<String> q) {
        return q.stream()
                .collect(Collectors.<String, String, Optional<List<String>>>toMap(
                        name -> name,
                        name -> Optional.of(list(request.getHeaders(name))) ));
    }
}
