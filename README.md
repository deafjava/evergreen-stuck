# Evergreen Stuck

Codebase of a RESTful service to check if Evergreen is stuck at Suez Channel! Enjoy!

# Code

- Programming language: <img src="/resources/clojure.png" alt="Clojure" width="20"/> Clojure!
- Libraries: Ring and Etaoin

# Enjoy!

## Is there an online running service?

Yes:  https://stuckevergreen.herokuapp.com/

## How this service gets status of Evergreen Situation?

This service do a scrape from https://istheshipstillstuck.com/, gets the status and returns a lightweight & beautiful RESTful status response :) 

# How to put to run when I want to use webdriver in Heroku with Clojure?

You can setup to run in Heroku, but the steps must be followed strictly because it's a bit tricky:

- Run heroku command to create a new app: `heroku apps:create <new-app>`
- Set environment variables for path of Google Chrome and Chrome Driver installations - you have to set according to chosen framework, the snippet below works for **Ring** framework
```clojure
  (def path-chromedriver "/app/.chromedriver/bin/chromedriver")
  (def path-google-chrome "/app/.apt/usr/bin/google-chrome")

  (defn handler [_]
    {:status  200
     :headers {"Content-Type" "application/json"}
     :body    {:hello :world}})

  (defn -main
     [& _]
        (let [port (Integer/parseInt (System/getenv "PORT"))]
            (run-jetty handler {:port         port
                                :path-driver  path-chromedriver
                                :path-browser path-google-chrome})))
```
- Add **Procfile** file at the root of the project to run the Clojure - `web: lein run` 
- Push the main branch `git push heroku main`. This first git push is mandatory to be done before adding buildpacks, else Clojure app will be never found by Heroku
- Add two buildpacks to allow app to use webdriver - Clojure app will be already added and considered as buildpack with index #1:
    - `heroku buildpacks:add --index 2 https://github.com/heroku/heroku-buildpack-google-chrome`
    - `heroku buildpacks:add --index 3 https://github.com/heroku/heroku-buildpack-chromedriver`
- Then do again - `git push heroku main` and buildpacks will be added. The order must be as is shown above, else it won't work properly.
- And voilá!

### Known issues
When you do some changes in the code, pushing again to heroku will break due to a bug of caching and automated user permission during first setting of two additional buildpacks, so you'll have to destroy and recreate the app, all whole steps again :( 
