$(document).ready(function () {
  /**
   * 全局變數
   */
  const input = $('.task_name');
  const addBlock = $('.task_add_block');
  const btn = $('.task_add');
  const ul = $('.task_list');

  /**
   * 第一步
   */
  input.on('focus', () => addBlock.addClass('-on'));
  input.on('blur ', () => addBlock.removeClass('-on'));

  /**
   * 第二步
   */

  // 新增
  btn.on('click', addBtn);
  // Enter
  input.on('keypress', (e) => {
    if (e.which == 13) addBtn();
  });

  /**
   * 第三步
   */
  // 刪除
  ul.on('click', '.btn_delete', function () {
    $(this).closest('li').fadeOut(1000);
    setTimeout(() => {
      $(this).closest('li').remove();
    }, 1000);
  });

  // 清空
  $('.btn_empty').on('click', () => {
    $('li').fadeOut(1000);
    // 等待一秒
    setTimeout(() => {
      $('li').remove();
    }, 1000);
  });

  /**
   * 第四步
   */
  // 更新
  ul.on('click', '.btn_update', function () {
    let p = $(this).closest('li').find('p');
    let input = $(this).closest('li').find('input');
    // 判斷
    if (input.hasClass('-none')) {
      p.addClass('-none');
      input.removeClass('-none');
      return;
    }
    // 判斷
    if (input.val().trim() === '') return alert('請輸入代辦事項');

    input.addClass('-none');
    p.text(input.val().trim()).removeClass('-none');
  });

  /**
   * 第五部
   */
  //上
  ul.on('click', '.btn_up', function () {
    //判斷
    if (!$(this).closest('li').is(':first-child')) {
      let index = $(this).closest('li').index();
      let initial = getText(index - 1);
      let up = getText(index);

      changeLi(index - 1, addLi(up));
      changeLi(index, addLi(initial));
    }
  });
  // 下
  ul.on('click', '.btn_down', function () {
    if (!$(this).closest('li').is(':last-child')) {
      let index = $(this).closest('li').index();
      let initial = getText(index + 1);
      let down = getText(index);
      changeLi(index + 1, addLi(down));
      changeLi(index, addLi(initial));
    }
  });

  /**
   * 第六部
   */
  // 星號
  ul.on('click', '.star', function () {
    $(this).siblings().removeClass('-on');
    $(this).addClass('-on');
    $(this).prevAll().addClass('-on');
  });

  /**
   * default
   */

  // 獲得文字
  function getText(index) {
    return $('li').eq(index).find('p').text();
  }

  // 交換 li
  function changeLi(index, li) {
    $('li').eq(index).replaceWith(li);
  }

  // 新增按鈕
  function addBtn() {
    if (!input.val().trim()) return;
    ul.append(addLi(input.val()));
    input.val('');
  }

  // 新增 li
  function addLi(input) {
    return `
    <li>
      <div class='item_flex'>
        <div class='left_block'>
          <div class='btn_flex'>
            <button type='button' class='btn_up'>
              往上
            </button>
            <button type='button' class='btn_down'>
              往下
            </button>
          </div>
        </div>
        <div class='middle_block'>
          <div class='star_block'>
            <span class='star' data-star='1'>
              <i class='fas fa-star'></i>
            </span>
            <span class='star' data-star='2'>
              <i class='fas fa-star'></i>
            </span>
            <span class='star' data-star='3'>
              <i class='fas fa-star'></i>
            </span>
            <span class='star' data-star='4'>
              <i class='fas fa-star'></i>
            </span>
            <span class='star' data-star='5'>
              <i class='fas fa-star'></i>
            </span>
          </div>
          <p class='para'>${input}</p>
          <input
            type='text'
            class='task_name_update -none'
            placeholder='更新待辦事項…'
            value="${input}"
          />
        </div>
        <div class='right_block'>
          <div class='btn_flex'>
            <button type='button' class='btn_update'>
              更新
            </button>
            <button type='button' class='btn_delete'>
              移除
            </button>
          </div>
        </div>
      </div>
    </li>`;
  }
});
