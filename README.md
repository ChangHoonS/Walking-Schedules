# ✅ Readme

## Walking-Schedule-Project

## API 명세서

| 기능        | Method | URL             | Request Body(dto)                                                                 | Response                                                                                     | Error Response                                                        | Status Code                |
|-------------|--------|-----------------|------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------|----------------------------|
| 일정 생성   | POST   | /schedules      | {<br> "writerId": "String",<br> "title": "String", <br> "content": "String" }       | {<br> "id": Long,<br> "writerId": "String",<br> "title": "String", <br> "content": "String",<br> "createdAt": DateTime,<br> "updatedAt": DateTime } | 400: 작성자는 필수입니다.<br> 400: 제목은 필수입니다.<br> 400: 내용은 필수입니다. | 201: Created<br> 400: Bad Request |
| 일정 수정   | PATCH  | /schedules/{id} | {<br> "title": "String", <br> "content": "String" }                                 | {<br> "id": Long,<br> "writerId": "String",<br> "title": "String", <br> "content": "String",<br> "createdAt": DateTime,<br> "updatedAt": DateTime } | 400: 제목은 필수입니다.<br> 400: 내용은 필수입니다.<br> 404: 일정을 찾을 수 없습니다. | 200: OK<br> 400: Bad Request<br> 404: Not Found |
| 일정 전체 조회 | GET    | /schedules      | X                                                                                  | [ {<br> "id": Long,<br> "writerId": "String",<br> "title": "String", <br> "content": "String",<br> "createdAt": DateTime,<br> "updatedAt": DateTime },<br> ... ] | X                                                                     | 200: OK                   |
| 일정 단건 조회 | GET    | /schedules/{id} | X                                                                                  | {<br> "id": Long,<br> "writerId": "String",<br> "title": "String", <br> "content": "String",<br> "createdAt": DateTime,<br> "updatedAt": DateTime } | 404: 일정을 찾을 수 없습니다.                                          | 200: OK<br> 404: Not Found  |
| 일정 삭제   | DELETE | /schedules/{id} | X                                                                                  | X                                                                                            | 404: 일정을 찾을 수 없습니다.                                          | 200: OK<br> 404: Not Found |

| 기능        | Method | URL                                   | Request Body(dto)                                                                 | Response                                                                                     | Error Response                                                        | Status Code                |
|-------------|--------|---------------------------------------|------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------|----------------------------|
| 댓글 생성   | POST   | /schedules/{id}<br>/comments              | {<br> "writerId": "String",<br> "content": "String" }                              | {<br> "scheduleId": Long,<br> "id": Long,<br> "writerId": "String",<br> "content": "String",<br> "createdAt": DateTime,<br> "updatedAt": DateTime } | 400: 작성자는 필수입니다.<br> 400: 내용은 필수입니다. | 201: Created<br> 400: Bad Request |
| 댓글 수정   | PATCH  | /schedules/{id}/<br>comments/{id}         | {<br> "title": "String", <br> "content": "String" }                                 | {<br> "scheduleId": Long,<br> "id": Long,<br> "writerId": "String",<br> "content": "String",<br> "createdAt": DateTime,<br> "updatedAt": DateTime } | 400: 내용은 필수입니다.<br> 404: 일정을 찾을 수 없습니다. | 200: OK<br> 400: Bad Request<br> 404: Not Found |
| 댓글 전체 조회 | GET    | /schedules/{id}/<br>comments              | X                                                                                  | [ {<br> "scheduleId": Long,<br> "id": Long,<br> "writerId": "String",<br> "content": "String",<br> "createdAt": DateTime,<br> "updatedAt": DateTime },<br> ... ] | X                                                                     | 200: OK                   |
| 댓글 단건 조회 | GET    | /schedules/{id}/<br>comments/{id}         | X                                                                                  | {<br> "scheduleId": Long,<br> "id": Long,<br> "writerId": "String",<br> "content": "String",<br> "createdAt": DateTime,<br> "updatedAt": DateTime } | 404: 댓글을 찾을 수 없습니다.                                          | 200: OK<br> 404: Not Found  |
| 댓글 삭제   | DELETE | /schedules/{id}/<br>comments/{id}         | X                                                                                  | X                                                                                            | 404: 댓글을 찾을 수 없습니다.<br> 404: 이미 삭제된 일정입니다. | 200: OK<br> 404: Not Found |

| 기능        | Method | URL                                   | Request Body(dto)                                                                 | Response                                                                                     | Error Response                                                        | Status Code                |
|-------------|--------|---------------------------------------|------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------|----------------------------|
| 대댓글 생성 | POST   | /schedules/{id}<br>/comments/{id}<br>/underComments | {<br> "writerId": "String",<br> "content": "String" }                              | {<br> "scheduleId": Long,<br> "commentId": Long,<br> "id": Long,<br> "writerId": "String",<br> "content": "String",<br> "createdAt": DateTime,<br> "updatedAt": DateTime } | 400: 작성자는 필수입니다.<br> 400: 내용은 필수입니다. | 201: Created<br> 400: Bad Request |
| 대댓글 수정 | PATCH  | /schedules/{id}<br>/comments/{id}<br>/underComments/{id} | {<br> "title": "String", <br> "content": "String" }                                 | {<br> "scheduleId": Long,<br> "commentId": Long,<br> "id": Long,<br> "writerId": "String",<br> "content": "String",<br> "createdAt": DateTime,<br> "updatedAt": DateTime } | 400: 내용은 필수입니다.<br> 404: 일정을 찾을 수 없습니다. | 200: OK<br> 400: Bad Request<br> 404: Not Found |
| 대댓글 조회 | GET    | /schedules/{id}<br>/comments/{id}<br>/underComments/{id} | X                                                                                  | {<br> "scheduleId": Long,<br> "commentId": Long,<br> "id": Long,<br> "writerId": "String",<br> "content": "String",<br> "createdAt": DateTime,<br> "updatedAt": DateTime } | 404: 댓글을 찾을 수 없습니다.                                          | 200: OK<br> 404: Not Found  |

##ERD

https://www.erdcloud.com/d/KdjG4aTdbhh5XDDN8

### 프로젝트 소개
걷기반의 일정 관리 앱을 만들어 CRUD에 익숙해지는 프로젝트

### 개발기간
- 2025.04.30(수) ~ 2025.05.13(화)

### 개발 내용
- 전반적인 CRUD 내용
- 개인적으로 보통 작성자는 변하지 않는다고 생각하여 수정시는 작성자를 제외하고 변경

- #### LV1. 일정 CRUD
  - 사용자는 일정을 생성할 수 있다.
  - 사용자는 일정을 조회할 수 있다.
    - 전체 일정 목록을 조회할 수 있다.
    - 단일 일정(상세)을 조회할 수 있다.
  - 사용자는 일정을 수정할 수 있다.
  - 사용자는 일정을 삭제할 수 있다.
  - 일정은 아래와 같은 필드를 가집니다.
    - `일정 제목(title)`, `일정 내용(content)`, `작성일(createdAt)`, `수정일(updatedAt)`, `작성자 ID(writerId)`
    - `작성일`, `수정일` 필드는 `JPA Auditing`을 활용하여 적용합니다.

 - #### LV2. 댓글 CRUD
    - 생성한 일정에 댓글을 남길 수 있습니다.
      - 댓글과 일정은 연관관계를 가집니다.
    - 댓글을 저장, 조회, 수정, 삭제할 수 있습니다.
    - 댓글은 아래와 같은 필드를 가집니다.
      - `댓글 내용(content)`, `작성일(createdAt)`, `수정일(updatedAt)`, `작성자 ID(writerId)`, `일정 ID(scheduleId)`
      - `작성일`, `수정일` 필드는 `JPA Auditing`을 활용하여 적용합니다.

- #### LV3. 게시물 조회 시 댓글 조회
    - 일정 목록 조회 시, 각 일정마다 댓글 개수(commentCount)를 함께 조회할 수 있습니다.
      - 댓글 개수는 조회할 때마다 계산하거나, 별도 필드를 통해 관리해도 무방합니다.
    -  일정 상세 조회 시, 해당 일정에 작성된 모든 댓글 목록을 함께 조회할 수 있습니다.
        - 댓글 목록은 작성일 기준 오름차순(작성 오래된 순)으로 정렬합니다. 

- #### LV4. 대댓글 (1 Depth)
  - 댓글에 답글(대댓글)을 작성할 수 있습니다.
    - 대댓글은 부모 댓글(parentComment)과 연관관계를 가집니다.
  - 대댓글은 1 Depth까지만 허용합니다.
    - 즉, 대댓글에 다시 대댓글은 불가능합니다.
  - 대댓글도 댓글과 동일한 필드를 가집니다.
    - `댓글 내용(content)`, `작성일(createdAt)`, `수정일(updatedAt)`, `작성자 ID(writerId)`, `일정 ID(scheduleId)`, `부모 댓글 ID(parentCommentId)`
  - 대댓글 조회 시, 부모 댓글 하위에 정렬되어 함께 조회합니다.
    - 부모 댓글 → 대댓글 순으로 정렬

### API 동작 캡처본 업로드

<details>
<summary>스케줄 생성</summary>
  
![Image](https://github.com/user-attachments/assets/4d97a2fa-5a5a-426f-a7cf-c7c14fc882e2)

</details>

<details>
<summary>스케줄 수정</summary>
  
![Image](https://github.com/user-attachments/assets/5900300a-c58c-48e0-addd-0c4d94594084)

</details>

<details>
<summary>댓글 생성</summary>
  
![Image](https://github.com/user-attachments/assets/d578f66f-ccc2-44cb-9a58-3c38c13fff24)

</details>

<details>
<summary>댓글 수정</summary>
  
![Image](https://github.com/user-attachments/assets/723ee28d-8470-4e3f-838c-465e556c5787)

</details>

<details>
<summary>댓글 단건 조회</summary>
  
![Image](https://github.com/user-attachments/assets/049db024-5e10-4399-af83-599ee3de623b)

</details>

<details>
<summary>대댓글 생성</summary>
  
![Image](https://github.com/user-attachments/assets/e58bf05b-7df9-4739-9248-6a5db51b9bad)

</details>

<details>
<summary>대댓글 수정</summary>
  
![Image](https://github.com/user-attachments/assets/be0cfa59-6f29-4ab6-aaa4-dc5e44cd0aee)

</details>

<details>
<summary>대댓글 조회</summary>
  
![Image](https://github.com/user-attachments/assets/43237c97-6a75-4710-ae68-eb46c9f56d50)

</details>

<details>
<summary>스케줄 단건 조회</summary>
  
![Image](https://github.com/user-attachments/assets/20f43d7b-f99b-44db-9c83-02738458aa2f)

</details>

<details>
<summary>스케줄 전체 조회</summary>
  
![Image](https://github.com/user-attachments/assets/1306afc6-c2b5-4fe2-8ffb-8d3bab4bf19b)

</details>

<details>
<summary>예외들</summary>
  
![Image](https://github.com/user-attachments/assets/65919733-4de7-4f63-9870-1b87a3ccb822)

![Image](https://github.com/user-attachments/assets/305114fb-8a9d-4a60-9a67-8e3fcb613909)

![Image](https://github.com/user-attachments/assets/335bfcc6-3a43-4ef2-aa32-508883c172ab)

![Image](https://github.com/user-attachments/assets/6643deeb-1e88-41a2-8ac8-f5931c64f117)

![Image](https://github.com/user-attachments/assets/ce53ff93-8039-496f-93d5-da099af3408f)

</details>















