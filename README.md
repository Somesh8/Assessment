# Assessment
Assessment of isro launcher API


## Features

- Added Custom Exception (NotFoundException.java) and COntrollerAdvice for global exception handling 
- Search feature
- Getting data from external API
- Added multiple dto's



## API Reference

### LAUNCHER API

#### save and display launchers from isro API
```http
  GET /launcher/getdata
```

#### Get all launchers from database

```http
  GET /launcher
```

#### Get specific launcher from database
```http
  GET /launcher/get/{lid}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `lid` | `string` | **Required**. launchers id |




#### save launchers

```http
  POST /launcher
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `launcher`      | `launcherDto` | **Required**. launcher is required |

#### update the launcher

```http
  PUT /launcher/{lid}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `lid` | `string` | **Required**. launchers id |
| `launcher` | `launcherDto` | **Required**. launcher is required |


#### Delete specific launcher from database
```http
  DELETE /launcher/{lid}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `lid` | `string` | **Required**. launchers id |





### CUSTOMER SATTELITE API

#### save and display satellite from isro API
```http
  GET /satellite/getdata
```

#### Get all satellite from database

```http
  GET /satellite
```

#### Get specific satellite from database
```http
  GET /satellite/get/{lid}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `lid` | `string` | **Required**. satellite id |


#### search satellite from database
```http
  GET /satellite/search?q={lid}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `q` | `string` | **Required**. search query |


#### save satellite

```http
  POST /satellite
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `satellite`      | `satelliteDto` | **Required**. satellite is required |

#### update the satellite

```http
  PUT /satellite/{lid}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `lid` | `string` | **Required**. satellites id |
| `satellite` | `satelliteDto` | **Required**. satellite is required |


#### Delete specific satellite from database
```http
  DELETE /satellite/{lid}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `lid` | `string` | **Required**. satellites id |
